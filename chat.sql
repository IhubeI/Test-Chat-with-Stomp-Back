
-- 사용자 테이블
CREATE TABLE users (
    user_id VARCHAR2(50) PRIMARY KEY,          -- 사용자 ID
    user_password VARCHAR2(100) NOT NULL,      -- 사용자 비밀번호
    user_name VARCHAR2(100) NOT NULL,          -- 사용자 이름
    email VARCHAR2(100) NOT NULL                -- 사용자 이메일
);

-- 메시지 번호를 위한 시퀀스
CREATE SEQUENCE chat_message_seq
    START WITH 1
    INCREMENT BY 1;
   
-- 채팅방
CREATE TABLE chatroom (
    chatroom_id VARCHAR2(10) PRIMARY KEY, -- 채팅방 ID (문자열 형식)
    participant1_id VARCHAR2(50) NOT NULL,    -- 참가자 1 ID
    participant2_id VARCHAR2(50) NOT NULL,    -- 참가자 2 ID
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
    CONSTRAINT fk_participant1 FOREIGN KEY (participant1_id) REFERENCES users(user_id), -- 외래 키 제약 조건
    CONSTRAINT fk_participant2 FOREIGN KEY (participant2_id) REFERENCES users(user_id), -- 외래 키 제약 조건
    CONSTRAINT chk_distinct_participants CHECK (participant1_id <> participant2_id) -- 서로 다른 사용자여야 함
);

-- 채팅방 번호를 생성하기 위한 시퀀스
CREATE SEQUENCE chatroom_seq
    START WITH 1 -- 시퀀스 시작 번호
    INCREMENT BY 1 -- 증가할 값
    NOCACHE; -- 캐시 사용 안 함

-- 트리거 생성
CREATE OR REPLACE TRIGGER trg_generate_chatroom_id
BEFORE INSERT ON chatroom
FOR EACH ROW
DECLARE
    v_room_id VARCHAR2(10); -- 방 번호를 저장할 변수
BEGIN
    SELECT 'room' || LPAD(chatroom_seq.NEXTVAL, 3, '0')
    INTO v_room_id
    FROM dual;
    :NEW.chatroom_id := v_room_id;
END;

--메세지
CREATE TABLE chat_messages (
    chat_id VARCHAR2(10) PRIMARY KEY,  -- 메시지 고유 ID (자동 증가)
    chatroom_id VARCHAR2(50) NOT NULL,   -- 채팅방 ID
    sender_id VARCHAR2(50) NOT NULL,      -- 발신자 ID
    receiver_id VARCHAR2(50),             -- 수신자 ID (필수 아님)
    message CLOB NOT NULL,                -- 메시지 내용 (긴 텍스트 허용)
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 메시지 전송 시간, 기본값은 현재 시간
);

-- 시퀀스 생성 구문
CREATE SEQUENCE chat_messages_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

-- 트리거 생성 구문
CREATE OR REPLACE TRIGGER chat_messages_trigger
BEFORE INSERT ON chat_messages
FOR EACH ROW
BEGIN
    IF :NEW.chat_id IS NULL THEN
        SELECT 'chat' || LPAD(chat_messages_seq.NEXTVAL, 3, '0')
        INTO :NEW.chat_id
        FROM dual;
    END IF;
END;
