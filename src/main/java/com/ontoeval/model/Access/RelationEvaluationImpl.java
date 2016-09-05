package com.ontoeval.model.Access;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ontoeval.model.RelationEvaluationVO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dchavesf on 5/09/16.
 */
public class RelationEvaluationImpl extends BaseDaoImpl<RelationEvaluationVO, Integer> implements RelationEvaluationDAO {
    private static final String url = "jdbc:mysql://localhost/DrOntoEval";
    private final Dao<RelationEvaluationVO, Integer> relationEvalDAO;


    public RelationEvaluationImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, RelationEvaluationVO.class);
        relationEvalDAO = DaoManager.createDao(connectionSource, RelationEvaluationVO.class);
        TableUtils.createTableIfNotExists(connectionSource, RelationEvaluationVO.class);
    }

    public static ConnectionSource CrearConexion() throws SQLException, IOException {
        ConnectionSource connectionSource = new JdbcConnectionSource(url,"root","root");
        return connectionSource;
    }


    public ArrayList<RelationEvaluationVO> getEvaluatedRelations(String ontology, String user) {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("Ontology",ontology);
        m.put("isRandom", true);
        m.put("User", user);
        try{
            return (ArrayList<RelationEvaluationVO>)relationEvalDAO.queryForFieldValuesArgs(m);
        }catch (SQLException e){
            System.out.println("Error en evaluatedTermsUser/TermEvaluationImpl "+e.getMessage());
            return null;
        }
    }

    public ArrayList<RelationEvaluationVO> getEvaluatedRelations(String ontology) {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("Ontology",ontology);
        m.put("isRandom", true);
        try{
            return (ArrayList<RelationEvaluationVO>)relationEvalDAO.queryForFieldValuesArgs(m);
        }catch (SQLException e){
            System.out.println("Error en evaluatedTermsUser/TermEvaluationImpl "+e.getMessage());
            return null;
        }
    }
}
