package com.codegym.medical_declaration.service;

import com.codegym.medical_declaration.model.Declaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<Declaration> findAll();

    void save(Declaration declaration);

    Declaration findById(int id);

    void update(Declaration d);

    void remove(int id);
}
