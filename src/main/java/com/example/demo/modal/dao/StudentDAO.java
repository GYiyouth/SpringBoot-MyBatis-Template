package com.example.demo.modal.dao;

import com.example.demo.modal.vo.StudentVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    @Select("SELECT * FROM TestDB.t_user")
    List<StudentVO> listAllStudent();
}
