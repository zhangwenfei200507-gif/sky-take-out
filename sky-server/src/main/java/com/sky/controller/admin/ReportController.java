package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * 数据统计相关接口
 */
@RestController
@RequestMapping("/admin/report")
@Api(tags="Data Statistics Related Interfaces")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 营业额统计
     * @param begin
     * @param end
     * @return
     */



    @GetMapping("/turnoverStatistics")
@ApiOperation("Revenue Statistics")
  public Result<TurnoverReportVO>   turnoverStatistics(
          @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate begin,
          @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
      return Result.success(reportService.getTurnoverStatistics(begin,end));
  }
    /**
     * 用户统计
     * @param begin
     * @param end
     * @return
             */
  @GetMapping("/userStatistics")
  @ApiOperation("User Statistics")
  public Result<UserReportVO> userStatistics(
          @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate begin,
          @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
        return Result.success(reportService.getUserStatistics(begin,end));

  }
    /**
     * 订单统计
     * @param begin
     * @param end
     * @return
     */

    @GetMapping("/ordersStatistics")
    @ApiOperation("Order Statistics")
    public Result<OrderReportVO> ordersStatistics(
            @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
        return Result.success(reportService.getOrderStatistics(begin,end));

    }
    /**
     * 销量排名top10
     * @param begin
     * @param end
     * @return
     */
    @GetMapping("/top10")
    @ApiOperation("Top 10 in sales")
    public Result<SalesTop10ReportVO> top10(
            @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
        return Result.success(reportService.getSalesTop10(begin,end));

    }


}


