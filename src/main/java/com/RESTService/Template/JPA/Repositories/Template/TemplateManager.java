package com.RESTService.Template.JPA.Repositories.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: change service name
@Repository(value = "*NAME*RepositoryManager")
public class TemplateManager {

    @Autowired
    private CRUDInterface CRUDInterface;

    // TODO: All interactions with the crud interface should occur here, no service should directly interact with the interface
    public TemplateManager() { }

}
