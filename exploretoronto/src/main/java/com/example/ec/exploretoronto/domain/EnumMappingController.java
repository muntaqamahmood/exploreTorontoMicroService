package com.example.ec.exploretoronto.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enummapping")
public class EnumMappingController {

    // curl http://localhost:8080/enummapping/getByDifficulty?difficulty=Easy => returns 'Easy'
    @GetMapping("/getByDifficulty")
    public String getByDifficulty(@RequestParam(required = false) Difficulty difficulty){
        if ((difficulty != null) && (difficulty.name().matches("\\b(Easy|Difficult|Medium|Varies)\\b"))) {
            return difficulty.name();
        }
        return "NULL";
    }

    // curl http://localhost:8080/enummapping/getByRegion?region=Durham -> 'Durham'
    @GetMapping("/getByRegion")
    public String getByRegion(@RequestParam(required = false) Region region) {
        if ((region != null) && (region.name().matches("\\b(York|Durham|Peel|Varies|Scarborough)\\b"))) {
            return region.name();
        }
        return "NULL";
    }
}