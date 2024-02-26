package com.codegym.medical_declaration.service.serviceImpl;

import com.codegym.medical_declaration.model.Declaration;
import com.codegym.medical_declaration.service.IMedicalDeclarationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    private static final List<Declaration> declarationList = new ArrayList<>();
    static {
        declarationList.add(new Declaration(1,"ĐINH VĂN KHANG", 2000, "Nam", "Việt Nam", "0123456789123",
                "Ô tô", "VN123", "A12", "11-2-2024", "22-3-2024", "Đà Nẵng", "Đà Nẵng, Liên Chiểu, Hoà Minh",
                "ádavasdafasfasda", "0123456789", "dvkhang49@gmail.com", null, null));
    }
    @Override
    public List<Declaration> findAll() {
        return declarationList;
    }

    @Override
    public void save(Declaration declaration) {

    }

    @Override
    public Declaration findById(int id) {
        for (Declaration d: declarationList) {
            if (id == d.getId()){
                return d;
            }
        }
        return null;
    }

    @Override
    public void update(Declaration d) {
        Declaration declaration = findById(d.getId());
        System.out.println(declaration);
        if (declaration != null){
            declarationList.remove(declaration);
            declarationList.add(d);
        }
    }

    @Override
    public void remove(int id) {

    }
}
