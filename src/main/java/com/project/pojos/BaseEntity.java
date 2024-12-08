package com.project.pojos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter@ToString
public class BaseEntity 
{
	
	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	private LocalDateTime createdOn;
	
	
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

}
