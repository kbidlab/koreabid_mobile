<?PHP
$code= $_GET['BidCode'];
$page= $_GET['reqpage'];
$fp = fsockopen("m.kbid.co.kr", 80, $errno, $srrstr, 30);
if (!$fp) {
	echo $errstr." ".$errno."<br />\n";
}
else {
	fputs($fp, "GET /Mobile/global/{$page}.htm?BidCode={$code} HTTP/1.0\r\n");
	fputs($fp, "Host: m.kbid.co.kr\r\n");
	fputs($fp, "Connection: Close\r\n\r\n");

	$header = "";
	while (!feof($fp)) {
		$out = fgets($fp,512);
		if (trim($out) == "") {
			break;
		}
		$header .= $out;
	}

	$body = "";
	while(!feof($fp)) {
		$out = fgets($fp,512);
		$body .= $out;
	}

	$idx = strpos(strtolower($header), "transfer-encoding: chunked");

	if ($idx > -1) {
		$temp = "";
		$offset = 0;
		do {
			$idx1 = strpos($body, "\r\n", $offset);
			$chunkLength = hexdec(substr($body, $offset, $idx1 - $offset));

			if ($chunkLength == 0) {
				break;
			}
			else {
				$temp .= substr($body. $idx1+2, $chunkLength);
				$offset = $idx1 + $chunkLength + 4;
			}
		} while(true);

		$body = $temp;
	}

	header("Content-Type: text/html; charset=utf-8");
	echo $body;
	fclose($fp);
}
?>
