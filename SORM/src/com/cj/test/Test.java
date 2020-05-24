package com.cj.test;

import com.cj.sorm.core.MySqlQuery;
import com.cj.sorm.core.Query;
import com.cj.sorm.core.QueryFactory;
import com.cj.vo.EmpVO;

import java.util.List;

/**
 * 客户端测试类
 *
 * @author CJ
 */
public class Test {
    public static void main(String[] args) {
        Query q = QueryFactory.createQuery();
        String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age, d.dname 'deptName',d.address'deptAddress' from emp e "
                + "join dept d on e.deptId=d.id ";
        List<EmpVO> list2 = q.queryRows(sql2, EmpVO.class, null);
        for (EmpVO e : list2) {
            System.out.println(e.getEmpname() + "---" + e.getDeptAddress() + "---" + e.getXinshui());
        }
    }
}
