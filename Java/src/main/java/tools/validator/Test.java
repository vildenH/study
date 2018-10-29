package tools.validator;

import lombok.Data;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * @author wh
 * @date 2018/10/25
 */
public class Test {

    public static void main(String[] args) throws UnknownHostException {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        UserBean userBean = new UserBean();
        userBean.setAge(12);
        userBean.setName("张三");
        userBean.setAddress("124444444112");
        userBean.setEmail("123");

        Set<ConstraintViolation<UserBean>> constraintViolations = validator.validate(userBean);
        for (ConstraintViolation constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
        }

    }

}

@Data
class UserBean {
    @Range(min = 20, max = 50, message = "age应该在[20，50]之间")
    private Integer age;

    @NotNull(message = "name不能为空")
    private String name;

    @Length(max = 100, message = "address不能超过100")
    private String address;

    @Email(message = "email格式不对")
    private String email;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
