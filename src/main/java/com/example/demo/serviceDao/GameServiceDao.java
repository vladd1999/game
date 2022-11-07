package com.example.demo.serviceDao;

import com.example.demo.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GameServiceDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Game selectGame(int id){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id",id);
        return namedParameterJdbcTemplate.queryForObject("select * from example.games where id = :id",parameters,new GameMapper());
    }
    private static class GameMapper implements RowMapper<Game>{

        @Override
        public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
            Game game = new Game();
            game.setId(rs.getInt("id"));
            game.setMaxPlayer(rs.getInt("maxPlayers"));
            game.setPasswordGame(rs.getString("gameId"));
            return game;
        }
    }
}
