<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		<%@include file="/resources/static/css/common.css" %>
		<%@include file="/resources/static/css/header.css" %>
		<%@include file="/resources/static/css/Main_Search_Page.css" %>
		<%@include file="/resources/static/css/footer.css" %>		
	</style>
</head>
<body>
	<div class="wrapper">
        <!-- 메인 -->
        <header>
            <div class="top-header">
                <a href="./index.jsp"><img class="logo" src="resources/static/img/로고.png" alt=""></a>
                <div class="search_box">
                    <div>SEARCH</div>
                    <input id="searchInput" type="text" placeholder="듣고 싶은 노래를 검색하세요!">
                    <a href=""><img src="resources/static/img/search.png" alt=""></a>
                </div>
                <ul>
                    <li><a href="" style="color:rgb(92, 115, 6); font-family: 'NanumSquareAceb';"><img
                                src="resources/static/img/add.png" alt=""> 멤버십가입</a></li>
                    <li><a href=""><img src="resources/static/img/english.png" alt="">ENGLISH</a></li>
                </ul>
            </div>
        </header>
        <nav>
            <div class="mobilemenu">
                <span href="" class="material-symbols-outlined">menu
                    <ul class="wa">
                        <li><a href="">수박차트</a></li>
                        <li><a href="">수박DJ</a></li>
                        <li><a href="">수박TV</a></li>
                        <li><a href="">수박매거진</a></li>
                        <li><a href="./QnA_Page.html">공지사항</a></li>
                        <li><a href="">마이페이지</a></li>
                    </ul>
                </span>
            </div>
            <div class="navi">
                <div class="Menu_left">
                    <ul class="one--depth">
                        <li>
                            <a href="">수박차트</a>
                            <ul class="two--depth">
                                <li><a href="./TOP100.html">국내TOP100</a></li>
                                <li><a href="">해외TOP100</a></li>
                                <li><a href="">최신음악</a></li>
                                <li><a href="">장르음악</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박DJ</a>
                            <ul class="two--depth">
                                <li><a href="">#투데이</a></li>
                                <li><a href="">테마장르</a></li>
                                <li><a href="">인기선곡</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박TV</a>
                            <ul class="two--depth">
                                <li><a href="">뮤직비디오</a></li>
                                <li><a href="">수박방송</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박매거진</a>
                            <ul class="two--depth">
                                <li><a href="">오늘의매거진</a></li>
                                <li><a href="">완결매거진</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="Menu_right">
                    <ul class="one--depth">
                        <li>
                            <a href="">공지사항</a>
                            <ul class="two--depth">
                                <li><a href="">공지사항</a></li>
                                <li><a href="./QnA_Page.html">QnA</a></li>
                                <li><a href="">자주하는질문</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">마이페이지</a>
                            <ul class="two--depth">
                                <li><a href="">정보수정</a></li>
                                <li><a href="">마이리스트</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
        <div class="header_line"></div>
        <main>
            <aside class="searchresult"> 검색 결과
                <div class="table-wrapper">
                    <table id="searchTable">
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Artist</th>
                            <th>Image</th>
                            <th>Controls</th>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td> <!-- 버튼들을 포함하는 열 -->
                                <button onclick="previous()">⏪</button>
                                <button onclick="togglePlayback(this)">▶</button>
                                <button onclick="next()">⏩</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </aside>
        </main>
        <footer>
            <div class="footer_line"></div>
            <div>
                <ul class="footer_menu">
                    <li><a href="">이용약관</a></li>
                    <li><a href="">고객센터</a></li>
                    <li><a href="">제휴/프로모션</a></li>
                    <li><a href=""> 개인정보처리방침</a></li>
                </ul>
            </div>
            <p></p>
            <div class="Site_info">
                <img id="footer_logo" src="./img/로고.png" alt="">
                <span class="Sitename">(주)WATERMELON MUSIC</span>
                <span>대구광역시 중구 중앙대로 366 반월센트럴타워 10층</span>
                <span>대표이사 : 윤치연, 김예솔, 이헌지, 최정기</span>
                <span>사업자등록번호 : 024-04-02023</span>
                <br>
                <span>문의전화 : 1544-1111 (평일 09:00-18:00)</span>
                <span>WATERMELON MUSIC으로 음악과 함께하는 즐거운 하루 보내세요!</span>
            </div>

        </footer>
    </div>
</body>
</html>