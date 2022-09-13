package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private final List<Integer> birthdayList = new ArrayList<>();
    private final List<String> genderList = new ArrayList<>();
    private final List<String> countryList = new ArrayList<>();
    private final List<String> renderList = new ArrayList<>();
    private final List<Integer> starDayList = new ArrayList<>();
    private final List<Integer> starMonthList = new ArrayList<>();
    private final List<Integer> starYearList = new ArrayList<>();
    private final List<Integer> endDayList = new ArrayList<>();
    private final List<Integer> endMonthList = new ArrayList<>();
    private final List<Integer> endYearList = new ArrayList<>();
    private final List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();

    {

        //Thêm năm sinh
        for (int i = 1950; i <= 2005; i++) {
            birthdayList.add(i);
        }


        //Thêm giới tính
        genderList.add("Nam");
        genderList.add("Nữ");

        //Thêm địa chỉ
        countryList.add("Việt Nam");
        countryList.add("Lào");
        countryList.add("Campuchia");
        countryList.add("Trung Quốc");

        //Thêm phương tiện
        renderList.add("Máy bay");
        renderList.add("Tàu thuyền");
        renderList.add("Ô tô");
        renderList.add("Khác");


        //Ngày bắt đầu
        for (int i = 1; i <= 30; i++) {
            starDayList.add(i);
        }


        //Tháng bắt đầu
        for (int i = 1; i <= 12; i++) {
            starMonthList.add(i);
        }

        //Năm bắt đầu
        starYearList.add(2021);
        starYearList.add(2022);

        //Ngày kết thúc
        for (int i = 1; i <= 30; i++) {
            endDayList.add(i);
        }

        //Tháng kết thúc
        for (int i = 1; i <= 12; i++) {
            endMonthList.add(i);
        }

        //Năm kết thúc
        endYearList.add(2021);
        endYearList.add(2022);

        //danh sách
        medicalDeclarationList.add(new MedicalDeclaration("NGUYEN TAT THANH", 1992, "Nam", "Việt Nam",
                "123450123", "Ô tô", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà, chưa đi đâu"));
        medicalDeclarationList.add(new MedicalDeclaration("DANG THI THUY TIEN", 1992, "Nữ", "Việt Nam",
                "123451234", "Tàu hỏa", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có tới nhà Tý,..."));
        medicalDeclarationList.add(new MedicalDeclaration("LE DAI LOI", 1992, "Nam", "Việt Nam",
                "123455678", "Xe máy", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà cả tuần trả bài, chưa đi đâu"));
        medicalDeclarationList.add(new MedicalDeclaration("HOANG MINH TRI", 1992, "Nữ", "Việt Nam",
                "123452222", "Xe xích lô", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Hay đi sang nhà Diễm"));
        medicalDeclarationList.add(new MedicalDeclaration("PHAN PHUOC DAI", 1992, "Nữ", "Việt Nam",
                "121125678", "Xe ba gác", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi siêu thị, nhà ông Đạt"));
        medicalDeclarationList.add(new MedicalDeclaration("PHAM DAT", 1992, "Nữ", "Việt Nam",
                "355455678", "Xe rác", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà, chưa đi đâu"));
        medicalDeclarationList.add(new MedicalDeclaration("HO HAI HOC", 1992, "Nam", "Việt Nam",
                "129000678", "Đi bộ", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà bạn A trong tuần"));
        medicalDeclarationList.add(new MedicalDeclaration("VO VAN TY", 1992, "Nam", "Việt Nam",
                "222455678", "Tên lửa", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà bạn Tiên,..."));
        medicalDeclarationList.add(new MedicalDeclaration("NGUYEN VAN PHUC", 1992, "Nam", "Việt Nam",
                "120985678", "Bay", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Đi chợ A..."));
        medicalDeclarationList.add(new MedicalDeclaration("DANG NGOC HUY", 1992, "Nam", "Việt Nam",
                "123409978", "Tàu ngầm", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi tới nhà Hùng"));
        medicalDeclarationList.add(new MedicalDeclaration("BUI CHI BAO", 1992, "Nam", "Việt Nam",
                "123455600", "Xe đạp", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà trong tuần"));
        medicalDeclarationList.add(new MedicalDeclaration("NGUYEN VAN THANH", 1992, "Nam", "Việt Nam",
                "933455678", "Cuốc bộ", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi sang nhà A,.."));
        medicalDeclarationList.add(new MedicalDeclaration("NGUYEN TAT HUAN", 1992, "Nam", "Việt Nam",
                "513455678", "Tàu điện ngầm", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Không đi đâu, chỉ ở nhà"));
        medicalDeclarationList.add(new MedicalDeclaration("HUYNH VAN NAM", 1992, "Nam", "Việt Nam",
                "841255678", "Xe tăng", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Đi ngủ nguyên tuần"));
    }

    @Override
    public List<Integer> birthdayList() {
        return birthdayList;
    }

    @Override
    public List<String> genderList() {
        return genderList;
    }

    @Override
    public List<String> countryList() {
        return countryList;
    }

    @Override
    public List<String> renderList() {
        return renderList;
    }

    @Override
    public List<Integer> starDayList() {
        return starDayList;
    }

    @Override
    public List<Integer> starMonthList() {
        return starMonthList;
    }

    @Override
    public List<Integer> starYearList() {
        return starYearList;
    }

    @Override
    public List<Integer> endDayList() {
        return endDayList;
    }

    @Override
    public List<Integer> endMonthList() {
        return endMonthList;
    }

    @Override
    public List<Integer> endYearList() {
        return endYearList;
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationList;
    }

    @Override
    public MedicalDeclaration findOne(String identity) {
        MedicalDeclaration medicalDeclaration = null;

        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentity().equals(identity)) {
                medicalDeclaration = new MedicalDeclaration(item.getName(), item.getBirthday(),
                        item.getGender(), item.getCountry(), item.getIdentity(), item.getRender(),
                        item.getVehicleNumber(), item.getSeats(), item.getStarDay(), item.getStarMonth(),
                        item.getStarYear(), item.getEndDay(), item.getEndMonth(), item.getEndYear(),
                        item.getInformation());
            }
        }
        return medicalDeclaration;
    }

    @Override
    public void update(String identity, MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentity().equals(identity)) {
                item.setName(medicalDeclaration.getName());
                item.setBirthday(medicalDeclaration.getBirthday());
                item.setGender(medicalDeclaration.getGender());
                item.setCountry(medicalDeclaration.getCountry());
                item.setIdentity(medicalDeclaration.getIdentity());
                item.setRender(medicalDeclaration.getRender());
                item.setVehicleNumber(medicalDeclaration.getVehicleNumber());
                item.setStarDay(medicalDeclaration.getStarDay());
                item.setStarMonth(medicalDeclaration.getStarMonth());
                item.setStarYear(medicalDeclaration.getStarYear());
                item.setEndDay(medicalDeclaration.getEndDay());
                item.setEndMonth(medicalDeclaration.getEndMonth());
                item.setEndYear(medicalDeclaration.getEndYear());
                item.setInformation(medicalDeclaration.getInformation());
            }
        }
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }
}
