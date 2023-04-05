$(function () {
  $.ajax({
    url: "https://dummyjson.com/users",
  }).done(function (result) {
    result.users.forEach((e) => {
      rederUsers(e);
    });

    function rederUsers(user) {
      const tableBodyElement = document.querySelector("tbody");
      tableBodyElement.innerHTML += ` <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.gender}</td>
                    <td>${user.birthDate}</td>
                    <td>${user.email}</td>
                    <td>
                      <img src="${user.image}" />
                    </td>
                    <td>
                      <button id="btn-edit" onclick="handleEdit(this)">edit</button>
                      <button id="btn-remove" onclick="handleRemove(this)">remove</button>
                    </td>
                  </tr>`;
    }
  });
});
