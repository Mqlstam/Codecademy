
package com.codecademy.dao;

import com.codecademy.domain.Course;
import javafx.collections.ObservableList;

public interface CourseDAO {
    ObservableList<Course> getCourses();
    ObservableList<String> getAllCourseNames();
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}