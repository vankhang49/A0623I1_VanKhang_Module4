package com.codegym.music_app.controller;

import com.codegym.music_app.model.Song;
import com.codegym.music_app.model.SongForm;
import com.codegym.music_app.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicAppController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IMusicAppService musicAppService;

    @GetMapping("")
    public String index(Model model) {
        List<Song> songs = musicAppService.findAll();
        model.addAttribute("songs", songs);
        return "/index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "/create";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getNameSong(), songForm.getArtist(),
                songForm.getKindOfMusic(), fileName);
        musicAppService.save(song);
        redirectAttributes.addFlashAttribute("message", "Created new song successfully !");
        return "redirect:/music";
    }
    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        Song song = musicAppService.findById(id);
        SongForm songForm = new SongForm(id, song.getNameSong(), song.getArtist(), song.getKindOfMusic(), null);
        model.addAttribute("songForm", songForm);
        return "/update";
    }
    @PostMapping("/update")
    public String update(SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getNameSong(), songForm.getArtist(),
                songForm.getKindOfMusic(), fileName);
        musicAppService.update(songForm.getId(), song);
        redirectAttributes.addFlashAttribute("message", "Update song successfully!");
        return "redirect:/music";
    }
    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable int id, RedirectAttributes redirectAttributes){
        boolean flag = musicAppService.remove(id);
        if (flag){
            redirectAttributes.addFlashAttribute("message", "Delete product successfully!");
        }
        return "redirect:/music";
    }
}
