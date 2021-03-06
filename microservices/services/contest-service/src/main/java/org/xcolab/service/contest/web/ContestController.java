package org.xcolab.service.contest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xcolab.model.tables.pojos.Contest;
import org.xcolab.service.contest.domain.contentarticle.ContestDao;
import org.xcolab.service.contest.service.contentarticle.ContestService;

import java.util.List;

@RestController
public class ContestController {

    private static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private ContestService contestService;

    @Autowired
    private ContestDao contestDao;

    @RequestMapping(value = "/contests", method = RequestMethod.GET)
    public List<Contest> getContests(
            @RequestParam(required = false) String contestUrlName,
            @RequestParam(required = false) Long contestYear) {
        return contestDao.findByGiven(contestUrlName, contestYear);
    }
}
