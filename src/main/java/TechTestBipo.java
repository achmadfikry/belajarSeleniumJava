import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TechTestBipo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Albert Einstein");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

    }
}

/*
4.
create table TblEmployeeMaster (
    EmployeeCode varchar(200) not null,
    EmployeeName varchar(200) not null
);

create table TblCompanyMaster(
    CompanyCode varchar(200) not null,
    CompanyName varchar(200) not null
);

create table TblEmployeeCompanyTransaction (
    EmployeeCode varchar(200),
    CompanyCode varchar(200),
    DateStart date
);

INSERT INTO TblEmployeeMaster (EmployeeCode, EmployeeName) VALUES
('TH001', 'Sgr. Peter Starford Quill'),
('TH002', 'Lt. Natalie Dee Portman'),
('TH003', 'Jake Clarkson'),
('TH004', 'Ryan Kelly Clarkson'),
('TH005', 'Joseph Tucker');

INSERT INTO TblEmployeeCompanyTransaction (EmployeeCode, CompanyCode, DateStart) VALUES
('TH001', 'BTH', '2012-02-01 00:00:00'),
('TH001', 'BCN', '2019-01-01 00:00:00'),
('TH001', 'BID', '2021-01-01 00:00:00'),
('TH002', 'BTH', '2018-01-01 00:00:00'),
('TH002', 'BPH', '2019-01-01 00:00:00'),
('TH003', 'BCN', '2013-01-01 00:00:00'),
('TH003', 'BCN', '2015-01-01 00:00:00'),
('TH003', 'BCN', '2016-01-01 00:00:00'),
('TH003', 'BCN', '2017-01-01 00:00:00'),
('TH003', 'BSG', '2018-01-01 00:00:00'),
('TH004', 'BCN', '2014-09-01 00:00:00'),
('TH004', 'BID', '2018-12-13 00:00:00'),
('TH005', 'BID', '2015-01-01 00:00:00'),
('TH005', 'BCN', '2015-08-03 00:00:00'),
('TH005', 'BHK', '2016-01-01 00:00:00');

INSERT INTO TblCompanyMaster (CompanyCode, CompanyName) VALUES
('BCN', 'BIPO China'),
('BHK', 'BIPO Hong Kong'),
('BID', 'BIPO Indonesia'),
('BPH', 'BIPO Philippines'),
('BSG', 'BIPO Singapore'),
('BTH', 'BIPO Thailand');

select * from TblEmployeeMaster a;
select * from TblEmployeeCompanyTransaction b;
select * from TblCompanyMaster c;

4.1.
select
a.EmployeeCode,
a.EmployeeName,
c.CompanyCode,
c.CompanyName,
b.DateStart
from
TblEmployeeMaster a inner join TblEmployeeCompanyTransaction b
on a.EmployeeCode = b.EmployeeCode
inner join TblCompanyMaster c
on b.CompanyCode = c.CompanyCode
where
a.EmployeeCode in ('TH004','TH005')
order by a.EmployeeCode, b.DateStart;

4.2.
select
a.EmployeeName,
c.CompanyName,
count(1) as Total
from
TblEmployeeMaster a inner join TblEmployeeCompanyTransaction b
on a.EmployeeCode = b.EmployeeCode
inner join TblCompanyMaster c
on b.CompanyCode = c.CompanyCode
where a.EmployeeCode in ('TH001','TH002','TH003')
group by	a.EmployeeName, c.CompanyName
order by 	a.EmployeeName, Total desc;



5.
Scenario 10000 users Punch In on 08:00 AM - 09:00 AM:
- Number of Threads (Users) : 10000 -> simulate users log in & Punch In Gradually
- Ramp Up Period : 3600 seconds (60 minutes / 1 Hour) -> simulate duration of time in 1 hour on 08:00 AM - 09:00 AM
- Loop Count : 1 -> simulate how many times users running the scenario


 */