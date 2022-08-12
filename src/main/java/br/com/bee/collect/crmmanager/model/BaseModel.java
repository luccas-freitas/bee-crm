package br.com.bee.collect.crmmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseModel {
    @JsonFormat(pattern="dd/MM/yyyy - HH:mm")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="dd/MM/yyyy - HH:mm")
    private LocalDateTime updatedAt;
}
