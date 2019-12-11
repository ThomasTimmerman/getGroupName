import React, { Component } from "react";

class FileUpload extends Component {
  constructor(props) {
    super(props);
    this.state = { file: [], description: "" };
  }

  handleSubmit = event => {
    event.preventDefault();
    let data = new FormData();
    data.append("file", this.state.file);
    //data.append("description", "william");
    data.append("description", this.state.description);

    fetch("http://localhost:8081/api/file/upload", {
      method: "POST",
      body: data
    })
      .then(res => {
        if (res.ok) {
          console.log(res.data);
          alert("File uploaded successfully.");
          this.props.history.push(`/filelist`);
        } else {
          console.log(res);
          alert("Error uploading file. \nTry again.\n" + res);
        }
      })

      .catch(err => console.error(err));
  };

  render() {
    console.log("FileUpload - Rendered");
    return (
      <div>
        <h3>Drop Demo</h3>
        <form>
          <input
            type="file"
            placeholder="Select File"
            name="file"
            onChange={event => {
              this.setState({
                file: event.target.files[0]
              });
            }}
          />
          <br />
          <input
            type="text"
            placeholder="Enter description"
            name="description"
            onChange={event => {
              this.setState({ description: event.target.value });
            }}
          />
          <br />

          <button className="badge badge-primary" onClick={this.handleSubmit}>
            Drop Demo
          </button>
        </form>
      </div>
    );
  }
}

export default FileUpload;
