package agence.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agence.model.Aeroport;

public class AeroportDaoSql extends DaoSQL implements AeroportDao
{
    /**
     * @param connexion
     */
    public AeroportDaoSql(Connection connexion)
    {
        super(connexion);
    }

    public List<Aeroport> findAll()
    {
        // Liste des aéroports que l'on va retourner
        List<Aeroport> aeroports = new ArrayList<Aeroport>();
        try
        {
            /*
             * Connexion à la BDD
             */

            preparedStatement = connexion
                    .prepareStatement("SELECT * FROM aeroport");
            // 4. Execution de la requête
            resultSet = preparedStatement.executeQuery();
            // 5. Parcoutuple de l'ensemble des résultats (ResultSet) pour
            // récupérer les valeutuple des colonnes du tuple qui correspondent
            // aux
            // valeur des attributs de l'objet
            while (resultSet.next())
            {
                // Creation d'un objet Aeroport
                Aeroport aeroport = new Aeroport(resultSet.getInt("idAero"),
                        resultSet.getString("nom"));
                // Ajout du nouvel objet Aeroport créé à la liste des aéroports
                aeroports.add(aeroport);
            } // fin de la boucle de parcoutuple de l'ensemble des résultats

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Retourne la liste de tous les aéroports
        return aeroports;
    }

    public Aeroport findById(Integer idAero)
    {
        // Déclaration d'un objet aeroport
        Aeroport aeroport = null;

        try
        {

            preparedStatement = connexion
                    .prepareStatement("SELECT * FROM aeroport where idAero=?");
            // Cherche l'idAero voulu dans la BDD
            preparedStatement.setInt(1, idAero);

            // Récupération des résultats de la requête
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                aeroport = new Aeroport(resultSet.getInt("idAero"),
                        resultSet.getString("nom"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return aeroport;
    }

    /* (non-Javadoc)
     * @see agence.dao.Dao#create(java.lang.Object)
     */
    @Override
    public void create(Aeroport obj)
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see agence.dao.Dao#update(java.lang.Object)
     */
    @Override
    public Aeroport update(Aeroport obj)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see agence.dao.Dao#delete(java.lang.Object)
     */
    @Override
    public void delete(Aeroport obj)
    {
        // TODO Auto-generated method stub
        
    }

}
