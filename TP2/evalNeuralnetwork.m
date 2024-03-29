function retval = evalNeuralnetwork(testingSample)
    global weights;
    global N;
    global g;
    global gLast;
    global NF;
    
    k 		= size(N)(1);
    retval 	= zeros(size(testingSample), 1);
    h = cell(k - 1, 1);
    v = cell(k, 1);
    for i = 1:size(testingSample)
      expectedValue = testingSample(i, N(1) + 1:N(1) + N(k))';
      v{1} = [-1; feval(NF, testingSample(i, 1:N(1)))'];
      [h, v] = calculateHAndV(k, h, v, weights, g, gLast);
      retval(i) = v{k}(2:N(k) + 1);
   endfor
endfunction