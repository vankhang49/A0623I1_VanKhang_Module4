package com.codegym.upload_music.controller;

import com.codegym.upload_music.model.Music;
import com.codegym.upload_music.model.MusicForm;
import com.codegym.upload_music.service.IMusicService;
import com.codegym.upload_music.service.serviceImpl.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    private final IMusicService musicService = new MusicService();
    @GetMapping("")
    public String showList(Model model){
        List<Music> musics = musicService.findAll();
        model.addAttribute("musics", musics);
        return"index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("musicForm", new MusicForm());
        return "create";
    }
    @PostMapping("/save")
    public String saveMusic(@ModelAttribute MusicForm musicForm, Model model){
        MultipartFile multipartFile = musicForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getName(), musicForm.getArtist(), musicForm.getType(), fileName);
        musicService.save(music);
        model.addAttribute("musicForm", musicForm);
        model.addAttribute("message", "Upload new music file successfully !");
        return "create";
    }
}
