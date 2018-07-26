package com.project.blog.miniblog.model.dto.postDto;

import com.project.blog.miniblog.model.postUser.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnregisterPost {
    private Long deleted_id;
    private String deleted_title;
    private String deleted_text;
    private LocalDateTime delete_date;
    private PostStatus deleted_status;
}
