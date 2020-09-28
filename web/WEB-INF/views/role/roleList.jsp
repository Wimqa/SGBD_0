<%--
  Created by IntelliJ IDEA.
  User: Code
  Date: 20-08-20
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<!-- Source : https://stackoverflow.com/questions/5967564/form-inside-a-table

-->

<div class="pageInfo">
    <h2 class="pageInfo"> Liste des rôles </h2>
    <div>
    <a id="retourListe" class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/role/createOne_getForm"> Créer un nouveau rôle</a>
    </div>
</div>



<!-- Table listant les roles avec infos sommaires -->
<table class="dataList table  table-dark table-hover">  <!-- autre value de attribut class : table-striped -->

    <thead>
    <tr>
        <th> ID </th>
        <th> Abbréviation</th>
        <th> Label</th>
        <th> Action</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td colspan="4"> </td>
    </tr>
    <c:forEach  var="role"  items="${requestScope.myRoleListRequestKey}">
        <tr>
            <td><c:out value="${role.id}" /></td>
            <td><c:out value="${role.abbreviation}" /></td>
            <td><c:out value="${role.label}" /></td>

            <td>
                <form method="post"  action="${pageContext.request.contextPath}/role" >
                    <input type="hidden" id="idRoleForm" name="idRoleFromForm"  value="${role.id}">
                    <!-- Pour chaque button :retirer redAlert ou greenAlert pour eviter le clignotement
                    et remplacer -danger ou -success par -primary quand tout sera implémenté -->
                    <button class="myFormActionButton btn btn-sm btn-outline-success greenAlert"
                            type='submit' name="actionFromForm" value="readOne" > Afficher </button>
                    <button class="myFormActionButton btn btn-sm btn-outline-danger redAlert"
                            type='submit' name="actionFromForm" value="editOne_getForm" > Editer </button>

                    <!-- Pour retirer la possibilité de suppression du rôle correspondant à celui de l'utilisateur actuellement connecté -->
                    <c:if test="${sessionScope.signedUser.rolesByIdRole.label!=role.label}">
                    <button class="myFormActionButton btn btn-sm btn-outline-danger redAlert"
                            type='submit' name="actionFromForm" value="deleteOne" > Supprimer </button>
                    </c:if>

                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>



