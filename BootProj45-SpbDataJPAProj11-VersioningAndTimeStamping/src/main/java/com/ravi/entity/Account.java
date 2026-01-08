package com.ravi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="ACCOUNT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "account_seq",initialValue = 100001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "ACCOUNT_NO")
	private Long accountno;
	
	@NonNull
	@Column(name = "BALANCE")
	private Double balance;
	
	@CreationTimestamp
	@Column(name = "CREATION_TIME",insertable = true,updatable = false)
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	@Column(name = "LASTLY_UPDATE_ON",updatable = true,insertable = false)
	private LocalDateTime lastlyUpdateOn;
	
	
	@Version
	@Column(name = "UPDATE_COUNT")
	private Integer updateCount; 

}
