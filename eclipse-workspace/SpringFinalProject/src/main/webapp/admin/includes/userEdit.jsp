<h1 class="page-header">Edit User</h1>

<div class="form-group col-xs-12 col-md-6">
        <label for="articleTitle">First Name</label>
        <input type="text" class="form-control" id="firstName" value="" required autofocus>
</div>
<div class="form-group col-xs-12 col-md-6">
        <label for="articleTitle">Last Name</label>
        <input type="text" class="form-control" id="lastName" value="" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Email</label>
    <input class="form-control" id="email" required></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="authorID">Username</label>
    <input type="text" class="form-control" id="userName" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleImage">Password</label>
    <input type="text" class="form-control" id="password" required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleContent">Active</label>
    <input type="text" class="form-control" id="active" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleContent">userCreateDate</label>
    <input type="text" class="form-control" id="userCreateDate" required>
</div>


<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=updateUser(); data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>