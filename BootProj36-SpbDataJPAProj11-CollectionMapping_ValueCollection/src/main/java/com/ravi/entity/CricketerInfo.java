package com.ravi.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;



import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "CRICKETER_INFO_CLM")
public class CricketerInfo {	
@Id
@SequenceGenerator(name="gen1",sequenceName = "CricketerInfo_seq",initialValue = 1001,allocationSize = 1)
@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
private Integer cId;

@NonNull
@Column(length = 20)
private String cName;

@NonNull
@Column(length = 20)
private String cAddrs;

@ElementCollection
@CollectionTable(name="CRICKETER_FRIENDS",joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "cId"))
@Column(name = "FRIENDS")
@NonNull
private List<String> cFriends;

@ElementCollection
@CollectionTable(name="CRICKETER_PHONES",joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "cId"))
@Column(name = "PHONE_NUMBER")
@NonNull
private Set<Long> cPhones;

@ElementCollection
@CollectionTable(name="CRICKETER_IDDETAILS",joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "cId"))
@MapKeyColumn(name = "ID_TYPE")
@Column(name = "ID_NUMBER")
@NonNull
private Map<String, String> idDetails; 
}
