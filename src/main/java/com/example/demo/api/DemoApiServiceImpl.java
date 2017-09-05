package com.example.demo.api;

import com.example.demo.modal.dao.StudentDAO;
import com.example.demo.modal.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemoApiServiceImpl implements DemoApiService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<StudentVO> listAll() {
        return studentDAO.listAllStudent();
    }
}
