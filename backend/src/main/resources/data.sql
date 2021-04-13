INSERT INTO user (id, area, name, prefered_session_type, profile_picture_url) VALUES  
 (1, 'Frankfurt', 'Nathan Martin', 'BOTH', 'https://randomuser.me/api/portraits/men/32.jpg'),  
 (2, 'Paris', 'Scarlett Simmons', 'LOCAL', 'https://randomuser.me/api/portraits/women/59.jpg');
 
INSERT INTO user_interest (user_id, interest) VALUES  
 (1, 'Java'), 
 (1, 'TDD'),  
 (2, 'C#'),  
 (2, 'Code Katas');
 
INSERT INTO user_video_conference_tool (user_id, video_conference_tool) VALUES  
 (1, 'Zoom'), 
 (1, 'MS Teams');
