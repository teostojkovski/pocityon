package com.example.pocityon.request;

import com.example.pocityon.model.Suggestion;
import lombok.Data;

import java.util.List;

@Data
public class CreateCategoryRequest {
    private String name;
    private String icon;
    private List<Suggestion> suggestions;
}
