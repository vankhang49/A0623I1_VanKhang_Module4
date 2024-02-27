package com.codegym.medical_declaration.controller;

import com.codegym.medical_declaration.model.Declaration;
import com.codegym.medical_declaration.service.IMedicalDeclarationService;
import com.codegym.medical_declaration.service.serviceImpl.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/declaration")
public class MedicalDeclarationController {
    @Autowired
    IMedicalDeclarationService medicalDeclarationService;

    private static final String[] gender = {"Nam", "Nữ", "Khác"};
    private static final String[] vehicle = {"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"};
    private static final String[] allExposureHistory = {"Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vật",
        "Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV"};
    private static final String[] allSymptomsList = {"Sốt", "Nôn/buồn nôn", "Ho", "Tiêu chảy", "Khó thở", "Xuất huyết ngoài da", "Đau họng", "Nổi ban ngoài da"};
    @GetMapping(value = "", produces = "text/plain; charset=UTF-8")
    public String showList(Model model){
        List<Declaration> declarationList = medicalDeclarationService.findAll();
        model.addAttribute("declarationList", declarationList);
        return "list";
    }
    @GetMapping("/{id}/info")
    public String showInfo(Model model, @PathVariable(name = "id") Integer id){
        Declaration declaration = medicalDeclarationService.findById(id);
        model.addAttribute("declaration", declaration);
        return "info";
    }
    @GetMapping("/{id}/update")
    public String showUpdate(Model model, @PathVariable(name = "id") Integer id){
        Declaration declaration = medicalDeclarationService.findById(id);
        String[] departureDay = declaration.getDepartureDay().split("-");
        model.addAttribute("dDay", departureDay[0]);
        model.addAttribute("dMonth", departureDay[1]);
        model.addAttribute("dYear", departureDay[2]);
        String[] endDay = declaration.getEndDate().split("-");
        model.addAttribute("eDay", endDay[0]);
        model.addAttribute("eMonth", endDay[1]);
        model.addAttribute("eYear", endDay[2]);
        String[] contactAddress = declaration.getContactAddress().split(",");
        model.addAttribute("city", contactAddress[0]);
        model.addAttribute("district", contactAddress[1]);
        model.addAttribute("ward", contactAddress[2]);
        model.addAttribute("declaration", declaration);
        model.addAttribute("genderList", gender);
        model.addAttribute("vehicleList", vehicle);
        model.addAttribute("allSymptomsList", allSymptomsList);
        model.addAttribute("allExposureHistory", allExposureHistory);
        return "update";
    }
    @PostMapping(value = "/update", produces = "text/plain; charset=UTF-8")
    public String updateDeclaration(@ModelAttribute ("declaration") Declaration declaration,
                                    @RequestParam("dDay") String[] dDay,
                                    @RequestParam("eDay") String[] eDay,
                                    @RequestParam("contactAddress") String[] cAddress, Model model){
        String departureDay = dDay[0] + "-" + dDay[1] + "-" + dDay[2];
        String endDay = eDay[0] + "-" + eDay[1] + "-" + eDay[2];
        String contactAddress = cAddress[0] + "," + cAddress[1] + "," + cAddress[2];
        declaration.setDepartureDay(departureDay);
        declaration.setEndDate(endDay);
        declaration.setContactAddress(contactAddress);
        medicalDeclarationService.update(declaration);
        model.addAttribute("message", "Cập nhật thành công!");
        return showList(model);
    }
}
