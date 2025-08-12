-- 코드를 입력하세요
SELECT member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as DATE_OF_BIRTH
from member_profile
where tlno is not null and month(date_of_birth) = 3 and GENDER = 'W'
order by member_id
