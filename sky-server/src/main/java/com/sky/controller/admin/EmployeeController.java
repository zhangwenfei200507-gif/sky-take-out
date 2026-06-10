package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVO>
    login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("Employee login：{}", employeeLoginDTO);
        Employee employee = employeeService.login(employeeLoginDTO);
        //After logging in successfully, generate a JWT token
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();
        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping
    @ApiOperation("Newly added employees")
    public Result save(@RequestBody EmployeeDTO employeeDTO){
        log.info("Newly added employees:{}",employeeDTO);
        System.out.println("The ID of the current thread:"
                +Thread.currentThread().getId());
     employeeService.save(employeeDTO);
        return Result.success();
    }

    /**
     * Employee page-baseed query
     * @param employeePageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("Employee page-based query")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
      log.info("Employee page-based query,Parameter is: {}",employeePageQueryDTO);
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * Enable or disable employee accounts
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("Enable or disable employee accounts")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("Enable or disable employee accounts: {},{}",status,id);
      employeeService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * Based id query employee imformation
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("Based id query employee imformation")
    public Result<Employee> getById(@PathVariable Long id){
       Employee employee= employeeService.getById(id);
 return Result.success(employee);
    }

    /**
     * Edit employee information
     * @param employeeDTO
     * @return
     */
    @PutMapping
    @ApiOperation("Edit employee information")
    public Result update(@RequestBody EmployeeDTO employeeDTO){
        log.info("Edit employee information: {}",employeeDTO);
        employeeService.update(employeeDTO);
        return Result.success();
    }
}
