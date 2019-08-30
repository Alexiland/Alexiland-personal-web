package com.alex.ghlibrary.dao;

import com.alex.ghlibrary.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
