package com.novi.DiabloDemoDrop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "file_model")
public class FileModel {

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    @Column(name = "Description")
    private String description;

    @Lob
    @Column(name = "audiofile")
    @JsonView(View.FileInfo.class)
    private byte[] audiofile;

    @OneToMany(mappedBy = "filemodel")
    private List<Comment> comments = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FileModel() {
    }

    public FileModel(String name, String datatype, byte[] audiofile, String description) {
        this.name = name;
        this.datatype = datatype;
        this.audiofile = audiofile;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return this.datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public byte[] getAudiofile() {
        return this.audiofile;
    }

    public void setAudiofile(byte[] audiofile) {
        this.audiofile = audiofile;
    }
}
