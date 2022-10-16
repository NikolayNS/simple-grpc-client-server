package com.dmitrenko.simplegrpcclientserver.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserView {
    private UUID publicId;
    private String phone;
    private List<Long> groups;
}
