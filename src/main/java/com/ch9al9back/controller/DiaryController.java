package com.ch9al9back.controller;

import com.ch9al9back.domain.Diary;
import com.ch9al9back.repository.DiaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaryController {
    private final DiaryRepository diaryRepository;

    public DiaryController(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @RequestMapping("/record")
    public String RecordDiary(@RequestBody Diary newRecord) throws Exception {
        Diary originRecord = diaryRepository.findByIdDate(newRecord.getUser_id(), newRecord.getDate());
        if(originRecord == null) {
            diaryRepository.recordWork(newRecord);
            return "success";
        } else {
            return "같은 날짜에 기록이 존재합니다.";
        }
    }

    @RequestMapping(value = "/fixRecord", method = RequestMethod.PUT)
    public String FixRecord(@RequestParam long cal_id, @RequestParam String start_time, @RequestParam String end_time) throws Exception {
        diaryRepository.fixRecord(cal_id,start_time, end_time);
        return "updated";
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.DELETE)
    public String DeleteRecord(@RequestParam long cal_id) throws Exception {
        diaryRepository.deleteRecord(cal_id);
        return "deleted";
    }

    @RequestMapping(value = "/getRecords", method = RequestMethod.GET)
    public List<Diary> GetRecords(@RequestParam long user_id, @RequestParam int month) throws Exception {
        return diaryRepository.findById(user_id, month);
    }

    @RequestMapping(value = "/getDateRecord", method = RequestMethod.GET)
    public Diary GetRecordByDate(@RequestParam long user_id, @RequestParam String date) throws Exception {
        return diaryRepository.findByIdDate(user_id, date);
    }

}
