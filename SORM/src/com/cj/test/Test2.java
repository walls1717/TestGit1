package com.cj.test;

import com.cj.sorm.core.Query;
import com.cj.sorm.core.QueryFactory;
import com.cj.vo.EmpVO;

import java.util.List;

/**
 * 测试连接池的效率
 *
 * @author CJ
 */
public class Test2 {

    public static void test01() {
        Query q = QueryFactory.createQuery();
        String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age, d.dname 'deptName',d.address'deptAddress' from emp e "
                + "join dept d on e.deptId=d.id ";
        List<EmpVO> list2 = q.queryRows(sql2, EmpVO.class, null);
        for (EmpVO e : list2) {
            System.out.println(e.getEmpname() + "---" + e.getDeptAddress() + "---" + e.getXinshui());
        }
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for(int i = 0; i < 3000; i++){
            test01();
        }
        long b = System.currentTimeMillis();
        System.out.println((b-a)); //不加连接池耗时：26264ms 添加连接池耗时：4291ms
    }
}
