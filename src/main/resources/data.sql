--ED-104-AA
--updated and removed mediaTypes (album/season/playlist)
INSERT INTO thumb (media_type, media_id, media_name, thumbs_down)
VALUES
    ('SONG', 1, 'Blue', 10),
    ('SONG', 2, 'Thunderstruck', 5),
    ('VIDEO_CLIP', 1, 'Funny Cats Compilation', 25),
    ('PODCAST_EPISODE', 1, 'Tech Weekly: AI Edition', 9);

--ED-104-AA
-- Add userId that voted thumbsUp
INSERT INTO user_votes_thumb_up (thumb_id, user_id_thumbs_up)
VALUES
-- Blue
(1, 1),
(1, 2),
(1, 3),
-- Thunderstruck
(2, 1),
(2, 4),
(2, 5),
-- Funny Cats Compilation
(3, 6),
(3, 7),
(3, 8),
-- Tech Weekly: AI Edition
(4, 9),
(4, 10),
(4, 1);

--ED-105-AA
-- Add userId that voted thumbsDown
INSERT INTO user_votes_thumb_down (thumb_id, user_id_thumbs_down)
VALUES
-- Blue
(1, 4),
(1, 5),
-- Thunderstruck
(2, 6),
-- Funny Cats Compilation
(3, 9),
(3, 10),
-- Tech Weekly: AI Edition
(4, 2),
(4, 3),
(4, 5);