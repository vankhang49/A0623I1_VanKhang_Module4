package com.codegym.web_app.controller;

import com.codegym.web_app.model.Song;
import com.codegym.web_app.model.SongForm;
import com.codegym.web_app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/web-app")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "nameSearch", defaultValue = "") String name){
        if (page < 0) {
            page = 0;
        }
//        Page<Blog> blogs = blogService.findAllByTitle(title, PageRequest.of(page, 5));
        Page<Song> songs = songService.findAllByName(name, PageRequest.of(page, 5));
        if (songs.isEmpty()) {
            model.addAttribute("message", "No songs found!");
        }
        model.addAttribute("listSong", songs);
        model.addAttribute("nameSearch", name);
        model.addAttribute("page", page);
        return"/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("songForm", new SongForm());
        return "/create";
    }

    @PostMapping("/save")
    public String saveMusic(@ModelAttribute(name = "songForm") SongForm songForm, BindingResult bindingResult,
                            RedirectAttributes redirect, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute(songForm);
            return "/create";
        }
        MultipartFile multipartFile = songForm.getSongPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File destFile = new File(fileUpload + "audios\\" + fileName);
            if (!destFile.exists()){
                multipartFile.transferTo(destFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getName(),songForm.getArtist(), songForm.getKindOfMusic(), fileName);
        songService.save(song);
        redirect.addFlashAttribute("message", "Add new successfully!");
//       Redirect chuyển về trang list
        return "redirect:/web-app";
    }

    @GetMapping("/{idUpdate}/update")
    public String showPageUpdate(Model model, @PathVariable(name = "idUpdate") Integer id) {
        Optional<Song> s = songService.findById(id);
        Song song = s.get();
        SongForm songForm = new SongForm(song.getId(), song.getName(), song.getArtist(), song.getKindOfMusic());
        model.addAttribute("songForm", songForm);
        return "/edit";
    }

    @PostMapping("/update")
    public String updateUser(@Validated @ModelAttribute("songForm") SongForm songForm, BindingResult bindingResult,
                             RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(songForm);
            return "/create";
        }
        MultipartFile multipartFile = songForm.getSongPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File destFile = new File(fileUpload + "audios\\" + fileName);
            if (!destFile.exists()){
                multipartFile.transferTo(destFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId() ,songForm.getName(),songForm.getArtist(), songForm.getKindOfMusic(), fileName);
        songService.save(song);
        redirect.addFlashAttribute("message", "Update successfully!");
//       Redirect chuyển về trang list
        return "redirect:/web-app";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idSongDelete") Integer id) {
        songService.deleteById(id);
        return "redirect:/web-app";
    }
}
