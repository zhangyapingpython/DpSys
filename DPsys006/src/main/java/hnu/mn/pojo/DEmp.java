package hnu.mn.pojo;

public class DEmp {
    private Integer empid;

    private String empname;

    private Integer empage;

    private Double empmoney;

    private Double empweight;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public Integer getEmpage() {
        return empage;
    }

    public void setEmpage(Integer empage) {
        this.empage = empage;
    }

    public Double getEmpmoney() {
        return empmoney;
    }

    public void setEmpmoney(Double empmoney) {
        this.empmoney = empmoney;
    }

    public Double getEmpweight() {
        return empweight;
    }

    public void setEmpweight(Double empweight) {
        this.empweight = empweight;
    }
}