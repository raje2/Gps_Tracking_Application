<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Owner Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="mb-4">GPS Tracker</h1>
    <form action="/get-vehicles" method="get" class="mb-3">
        <div class="form-group">
            <label for="ownerId">Owner ID:</label>
            <input type="text" class="form-control" id="ownerId" name="ownerId" required>
        </div>
        <button type="submit" class="btn btn-info">Get Vehicle List</button>
    </form>
</div>

</body>
</html>
