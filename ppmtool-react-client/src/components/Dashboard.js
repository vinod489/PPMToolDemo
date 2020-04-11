import React, { Component } from "react";
import ProjectItem from "./ProjectItem";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1>Welcome to Dashboard</h1>
        <ProjectItem />
        <ProjectItem />
        <ProjectItem />
      </div>
    );
  }
}

export default Dashboard;
