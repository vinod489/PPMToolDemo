import axios from "axios";
import { GET_ERRORS } from "./types";
import qs from "qs";

export const createProject = (project, history) => async (dispatch) => {
  try {
    console.log("Project -->", project);
    // const project2 = {
    //   endDate: "2020-04-30 11:59:00",
    //   projectDescription: "Testing description",
    //   projectIdentifier: "RECT4",
    //   projectName: "Testing Project",
    //   startDate: "2020-04-01 11:59:00",
    // };
    const res = await axios.post("http://localhost:8081/api/project/", project);
    history.push("/dashboard");
  } catch (err) {
    console.log("error -->", err);
    let errorData = err;
    if (err.response && err.response.data) {
      errorData = err.response.data;
    }
    dispatch({
      type: GET_ERRORS,
      payload: errorData,
    });
  }
};
