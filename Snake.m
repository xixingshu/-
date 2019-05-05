function snake
  axis equal                    %����������Ϊ�Գ�      
  axis(0.5+[0, 20, 0, 20])          %��0.5��Ϊ��֮���ǽ����ײ���ķ���
  set(gca,'xtick',[],'ytick',[],'xcolor','w','ycolor','w')      %����������
  set(gca, 'color', 'y')
  hold on                                                  
  snakeTop = [5, 5];                   %������ͷ�ĳ�ʼλ��
  snakeDirect = [1, 0];                %�ߵķ���
  body = [5, 5 ; 4, 5 ; 3, 5];          %����ĳ�ʼλ������  
  long = 3;                                 %�ߵĳ���            
  food = [10, 10];                        %ʳ��ĳ�ʼλ��
  plotSnake = scatter(gca, body(:, 1), body(:, 2), 220, 'bs', 'filled');                  %ͨ������scatter��������scatter�ǻ�ɢ��ͼ�ĺ���
  plotFood = scatter(gca, food(1), food(2), 150, 'g', 'filled');                           %ͨ������scatter����ʳ��
  set(gcf, 'KeyPressFcn', @key)                                                                     %���ð����ж�
  fps = 5;                                    
  game = timer('ExecutionMode', 'FixedRate', 'Period',1/fps, 'TimerFcn', @snakeGame);       %���ö�ʱ���Ĳ���
  start(game)                               %��ʼ��Ϸ
 
   function snakeGame(~,~)
    snakeTop = snakeTop + snakeDirect;              %�ߵ��ƶ�
    body = [snakeTop; body] ;                                 
    while length(body)> long
      body(end, : ) = [];         
    end
    
    if intersect(body(2 : end, : ), snakeTop, 'rows')               %�ж���ͷ�Ƿ�ײ���Լ�������
        ButtonName1 = questdlg('��Ϸ������������ť����......','Gave Over','���¿�ʼ','�ر���Ϸ', 'Yes');
        if ButtonName1 == '���¿�ʼ'
            clf;
            snake();
        else
            close;
        end
    end      
    
    if isequal(snakeTop, food)             %�ж��Ƿ�Ե�ʳ��
      long = long + 1;                   
      food = randi(20, [1, 2]); 
      while any(ismember(body, food, 'rows'))
          food = randi(20, [1, 2]);
      end
    end        
    
    if (snakeTop(1, 1)>20)||(snakeTop(1, 1)<1)||(snakeTop(1, 2)>20)||(snakeTop(1, 2)<1)         %�ж��Ƿ�ײ��ǽ��
        ButtonName2 = questdlg('��Ϸ������������ť����......','Gave Over','���¿�ʼ','�ر���Ϸ', '�ر���Ϸ');
        if ButtonName2 == '���¿�ʼ'
            clf;
            snake();
        else
            close;
        end
    end
    
    set(plotFood, 'XData', food(1),  'YData', food(2));             %���ϵ�ˢ�»���
    set(plotSnake, 'XData', body( : , 1), 'YData', body( : , 2));
  end
 
  function key(~,event)       
    switch event.Key            
      case 'uparrow'
        direct = [0, 1];
      case 'downarrow'
        direct = [0, -1];
      case 'leftarrow'
        direct = [-1, 0];
      case 'rightarrow'
        direct = [1, 0];
      case 'space'
        stop(game); 
        direct = snakeDirect;
        ButtonName3 = questdlg('��Ϸ��ͣ......', 'Stop ', '���¿�ʼ', '�ر���Ϸ', '������Ϸ', '�ر���Ϸ');
        if ButtonName3 == '���¿�ʼ'
            clf;
            snake();
        elseif ButtonName3 == '�ر���Ϸ'
            close;
        else
           start(game);
        end   
      otherwise
        direct = nan;
    end
    if any(snakeDirect + direct)   
      snakeDirect = direct;
    end
  end
end
