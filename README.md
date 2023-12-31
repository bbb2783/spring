# 회원 관리 시스템

회원가입의 종류는 일반회원, 관리자, 사업자 3가지로 각각 다른 역할을 이용할 수 있습니다

# 기술스택

- java : 17
- Spring boot : 3.1.4
- build : gradle
- database : MySQL

## 주요기능

<details>
<summary><h3>공통부분</h3></summary>
- 일반 회원, 사업자, 관리자 모든계정은 아이디 비밀번호 이메일 입력받으며 아이디 중복이 있을경우 회원가입이 불가능하며 아이디, 비밀번호 미입력시 회원가입이 불가능합니다.<br>
- 사업자 계정으로 회원가입시 추가적으로 사업자 번호를 입력 받으며 공공데이터 api 사업자번호조회 시스템을 이용하여 사업자 번호가 있는지 없는지 구별합니다.<br>
- 모든계정은 회원정보조회 및 변경을 통해 현재 비밀번호, 이메일, 현재 잔액, 회원가입일시를 확인할수 있으며 비밀번호, 이메일을 변경할수 있습니다.<br>
- 로그인시 아이디, 비밀번호 미입력시 팝업문구가 등장합니다
</details>

<details>
<summary><h3>일반회원</h3></summary>
- 입금(개발예정)<br>
- 출금(개발예정)<br>
- 이체(개발예정)<br>
- 나의 거래 내역(개발예정)<br>
- 회원정보조회 및 변경<br>
- logout<br>
</details>

<details>
<summary><h3>사업자</h3></summary>
- 매장관리<br>
- 입금(개발예정)<br>
- 출금(개발예정)<br>
- 이체(개발예정)<br>
- 나의 거래 내역(개발예정)<br>
- 회원정보조회 및 변경<br>
- logout<br>
</details>

<details>
<summary><h3>관리자</h3></summary>
- 입금(개발예정)<br>
- 출금(개발예정)<br>
- 이체(개발예정)<br>
- 나의 거래 내역(개발예정)<br>
- 회원정보조회 및 변경<br>
- logout<br>
- 전체 회원 리스트<br>
- 전체 거래 내역<br>
</details>

<details>
<summary><h3>db</h3></summary>
- 회원관리<br>

</details>
