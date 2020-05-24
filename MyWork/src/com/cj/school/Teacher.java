package com.cj.school;

/**
 * 老师类
 * @version 2020-5-7
 * @author CJ
 */
public class Teacher extends AbstractEmployee{
    private final String title;

    /**
     * 新增加了职称
     * @param name 名称
     * @param title 职称
     * @param sex 性别
     */
    protected Teacher(String name, String title, String sex) {
        super(name, sex);
        this.title = title;
    }

    /**
     * 计算教师的津贴
     * @return 返回教师津贴
     */
    @Override
    public double subSidy() {
        switch (title) {
            case "教授":
                return 1200;
            case "副教授":
                return 800;
            case "讲师":
                return 500;
            default:
                return 300;
        }
    }

    /**
     * 判断教师是否是骨干员工
     * 依据职称判断
     * @return true：骨干员工，false：不是
     */
    @Override
    public boolean important() {
        return "副教授".equals(title) || "教授".equals(title);
    }
}
