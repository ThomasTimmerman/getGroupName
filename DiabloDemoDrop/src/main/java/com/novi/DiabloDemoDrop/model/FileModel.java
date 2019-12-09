package com.novi.DiabloDemoDrop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="file_model")
public class FileModel {
	@Id
	@GeneratedValue
    @Column(name = "id")
	@JsonView(View.FileInfo.class)
    private Long id;
	
    @Column(name = "name")
    @JsonView(View.FileInfo.class)
	private String name;
    
    @Column(name = "datatype")
	private String datatype;
	
	@Lob
    @Column(name="audiofile")
        @JsonView(View.FileInfo.class)
    private byte[] audiofile;
	
	public FileModel(){}
	
	public FileModel(String name, String datatype, byte[] audiofile){
		this.name = name;
		this.datatype = datatype;
		this.audiofile = audiofile;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDatatype(){
		return this.datatype;
	}
	
	public void setDatatype(String datatype){
		this.datatype = datatype;
	}
	
	public byte[] getAudiofile(){
		return this.audiofile;
	}
	
	public void setAudiofile(byte[] audiofile){
		this.audiofile = audiofile;
	}
}