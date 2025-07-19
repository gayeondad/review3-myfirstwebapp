<!doctype html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
  </head>
  <body>
    <h1 class="d-flex justify-content-center m-5">Welcome to ${sessname}</h1>
    <div><a href="list-todos">go list</a></div>
    <div class="m-5 border rounded p-5">
		<div class="d-flex flex-row mb-3 border">
		  <div class="p-2 border">Flex item 1 (flex-row)</div>
		  <div class="p-2 border">Flex item 2 </div>
		  <div class="p-2 border">Flex item 3 (default: flex-row)</div>
		</div>
		<div class="d-flex justify-content-start mb-3 border">
		  <div class="p-2 border">Flex item 1 (justify-content-start)</div>
		  <div class="p-2 border">Flex item 2 (start/end/center/between/around/evenly)</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex justify-content-between mb-3 border">
		  <div class="p-2 border">Flex item 1 (-between)</div>
		  <div class="p-2 border">Flex item 2</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex justify-content-around mb-3 border">
		  <div class="p-2 border">Flex item 1 (-around)</div>
		  <div class="p-2 border">Flex item 2</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex justify-content-evenly mb-3 border">
		  <div class="p-2 border">Flex item 1 (-evenly)</div>
		  <div class="p-2 border">Flex item 2</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex align-items-center mb-3 border" style="height: 100px;">
		  <div class="p-2 border">Flex item 1 (align-items-center)</div>
		  <div class="p-2 border">Flex item 2 (start/end/center/baseline/stretch)</div>
		  <div class="p-2 border">Flex item 3 (default: stretch)</div>
		</div>
		<div class="d-flex mb-3 border">
		  <div class="p-2 flex-fill border">Flex item 1 (flex-fill)</div>
		  <div class="p-2 flex-fill border">Flex item 2 (flex-fill)</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex mb-3 border">
		  <div class="p-2 flex-grow-1 border">Flex item 1 (flex-grow-1)</div>
		  <div class="p-2 border">Flex item 2</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex mb-3 border">
		  <div class="p-2 me-auto border">Flex item 1 (ms-auto/me-auto)</div>
		  <div class="p-2 border">Flex item 2</div>
		  <div class="p-2 border">Flex item 3</div>
		</div>
		<div class="d-flex align-content-center flex-wrap mb-3 border" style="height: 100px;">
		  <div class="p-2 border">Flex item 1 (align-content-start)</div>
		  <div class="p-2 border">Flex item 2 (start/end/center/between/around/stretch)</div>
		  <div class="p-2 border">Flex item 3 (with flex-wrap)</div>
		  <div class="p-2 border">Flex item 4</div>
		  <div class="p-2 border">Flex item 5</div>
		  <div class="p-2 border">Flex item 6</div>
		  <div class="p-2 border">Flex item 7</div>
		  <div class="p-2 border">Flex item 8</div>
		  <div class="p-2 border">Flex item 9</div>
		  <div class="p-2 border">Flex item 10</div>
		  <div class="p-2 border">Flex item 11</div>
		  <div class="p-2 border">Flex item 12</div>
		  <div class="p-2 border">Flex item 13</div>
		  <div class="p-2 border">Flex item 14</div>
		  <div class="p-2 border">Flex item 15</div>
		  <div class="p-2 border">Flex item 16</div>
		</div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
  </body>
</html>