package cn.imust.yktlms.mapper;


import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.entity.Student;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface StudentMapper extends MyMapper<Student> {

    /**
     * 分页查询学生信息
     * @param pagingVO
     * @return
     */
    List<Student> findByPaging(PagingVO pagingVO);

    int countStudentNumber();

    List<Student> selectBystudentName(String studentName);
}
