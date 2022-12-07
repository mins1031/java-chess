package com.example.javachess.console.board;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.WhiteTeam;

import java.util.Arrays;
import java.util.List;

public class BoardBasicInfo {
    public static final List<Team> BASIC_TEAMS_IN_CHESS = Arrays.asList(new BlackTeam(), new WhiteTeam());

}
